//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Schule2000
{
    using System;
    using System.Collections.Generic;
    
    public partial class schueler
    {
        public schueler()
        {
            this.klassen = new HashSet<klassen>();
            this.klassen1 = new HashSet<klassen>();
            this.pruefungen = new HashSet<pruefungen>();
        }
    
        public short S_SCHNR { get; set; }
        public string S_Name { get; set; }
        public string S_Vorname { get; set; }
        public Nullable<System.DateTime> S_Gebdat { get; set; }
        public string S_Adresse { get; set; }
    
        public virtual ICollection<klassen> klassen { get; set; }
        public virtual ICollection<klassen> klassen1 { get; set; }
        public virtual klassen klassen2 { get; set; }
        public virtual ICollection<pruefungen> pruefungen { get; set; }
    }
}
