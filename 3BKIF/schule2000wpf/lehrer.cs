//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace schule2000wpf
{
    using System;
    using System.Collections.Generic;
    
    public partial class lehrer
    {
        public lehrer()
        {
            this.klassen = new HashSet<klassen>();
            this.lehrer1 = new HashSet<lehrer>();
            this.pruefungen = new HashSet<pruefungen>();
            this.stunden = new HashSet<stunden>();
            this.vorgesetzte = new HashSet<vorgesetzte>();
            this.vorgesetzte1 = new HashSet<vorgesetzte>();
        }
    
        public string L_ID { get; set; }
        public string L_Name { get; set; }
        public string L_Vorname { get; set; }
        public Nullable<System.DateTime> L_Gebdat { get; set; }
        public Nullable<float> L_Gehalt { get; set; }
    
        public virtual ICollection<klassen> klassen { get; set; }
        public virtual ICollection<lehrer> lehrer1 { get; set; }
        public virtual lehrer lehrer2 { get; set; }
        public virtual ICollection<pruefungen> pruefungen { get; set; }
        public virtual ICollection<stunden> stunden { get; set; }
        public virtual ICollection<vorgesetzte> vorgesetzte { get; set; }
        public virtual ICollection<vorgesetzte> vorgesetzte1 { get; set; }
    }
}
