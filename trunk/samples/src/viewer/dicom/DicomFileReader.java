package viewer.dicom;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.apache.log4j.Logger;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.dcm4che2.io.DicomInputStream;

import viewer.data.Image;
import viewer.data.Patient;
import viewer.data.Series;
import viewer.data.Study;

/**
 * This class contains all the DICOM specific stuff.
 * It uses the DICOM toolkit <a href=http://www.dcm4che.org>dcm4che</a>
 * @author Radlbauer
 *
 */
public class DicomFileReader
{

	// in this map we store all the patients loaded up to now
	private Map<String, Patient> patientMap = new HashMap<>();
	
	// reader for loading the pixel data
	private ImageReader imageReader;

	public DicomFileReader() throws Exception
	{
		Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("DICOM");
		if (readers.hasNext())
			imageReader = readers.next();
		else
			throw new Exception("no DICOM image reader found");
	}
	
	public BufferedImage readImage(File dicomFile) throws IOException
	{
		imageReader.setInput(new FileImageInputStream(dicomFile));
		return imageReader.read(0);
	}
	
	public void readHeaders(File directory) throws IOException
	{
		if(!add(directory, patientMap))
			throw new IOException("there were errors when reading DICOM files - see log file for details");
		
	}
	
	
	public Collection<Patient> getPatients()
	{
		return patientMap.values();
	}
	
	public void clear()
	{
		patientMap.clear();
	}
	
	private boolean add(File f, Map<String, Patient> patients)
	{
		boolean ok = true;
		if (f.isFile())
		{
			try
			{
				DicomInputStream input = new DicomInputStream(f);
				DicomObject dcm = input.readDicomObject();
				Patient p = readPatient(dcm);
				Patient existing = patients.get(p.getPatientID());
				if (existing == null)
				{
					existing = p;
					patients.put(p.getPatientID(), existing);
				}
				Study study = existing.add(readStudy(dcm));
				Series series = study.add(readSeries(dcm));
				Image image = series.add(readImage(dcm));
				image.setFile(f);
			} catch (IOException e)
			{
				Logger.getLogger(DicomFileReader.class).warn("not a dicom file: " + f, e);
				ok = false;
			}
		}
		else
		{
			for (File sub : f.listFiles())
			{
				if (!add(sub, patients))
					ok = false;
			}
		}
		return ok;
	}
	
	
	
	private Patient readPatient(DicomObject dcm)
	{
		Patient p = new Patient();
		p.setPatientID(dcm.getString(Tag.PatientID));
		p.setPatientName(dcm.getString(Tag.PatientName));
		p.setBirth(dcm.getDate(Tag.PatientBirthDate));
		p.setSex(dcm.getString(Tag.PatientSex).charAt(0));
		return p;
	}
	
	private Study readStudy(DicomObject dcm)
	{
		Study s = new Study();
		s.setStudyInstanceUID(dcm.getString(Tag.StudyInstanceUID));
		Date begin = new Date(dcm.getDate(Tag.StudyDate).getTime() + dcm.getDate(Tag.StudyTime).getTime());
		s.setStudyBegin(begin);
		return s;
	}
	
	private Series readSeries(DicomObject dcm)
	{
		Series s = new Series();
		s.setSeriesInstanceUID(dcm.getString(Tag.SeriesInstanceUID));
		s.setSeriesNumber(dcm.getInt(Tag.SeriesNumber));
		Date begin = new Date(dcm.getDate(Tag.SeriesDate).getTime() + dcm.getDate(Tag.SeriesTime).getTime());
		s.setSeriesBegin(begin);
		return s;
	}
	
	private Image readImage(DicomObject dcm)
	{
		Image image = new Image();
		image.setSopInstanceUID(dcm.getString(Tag.SOPInstanceUID));
		image.setImageNumber(dcm.getInt(Tag.InstanceNumber));
		image.setRows(dcm.getInt(Tag.Rows));
		image.setColumns(dcm.getInt(Tag.Columns));
		image.setAcquisitionTime(dcm.getDate(Tag.AcquisitionDateTime));
		return image;
	}
}
