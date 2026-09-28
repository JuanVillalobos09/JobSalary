public class Empleado {
    private String cargo, industria, educacion, modalidad, empresa, pais;
    private double experiencia, salario;
    private int certificaciones, skills;

    // Constructor para inicializar los datos extraídos del CSV
    public Empleado(String cargo, String industria, String educacion, double experiencia,
                    int certificaciones, String modalidad, String empresa, String pais,
                    double salario, int skills) {
        this.cargo = cargo; this.industria = industria; this.educacion = educacion;
        this.experiencia = experiencia; this.certificaciones = certificaciones;
        this.modalidad = modalidad; this.empresa = empresa; this.pais = pais;
        this.salario = salario; this.skills = skills;
    }

    // Getters necesarios para el análisis funcional
    public String getCargo() { return cargo; }
    public String getIndustria() { return industria; }
    public String getEducacion() { return educacion; }
    public double getExperiencia() { return experiencia; }
    public int getCertificaciones() { return certificaciones; }
    public String getModalidad() { return modalidad; }
    public String getEmpresa() { return empresa; }
    public String getPais() { return pais; }
    public double getSalario() { return salario; }
    public int getSkills() { return skills; }

    @Override
    public String toString() {
        return cargo + " | " + industria + " | Exp: " + experiencia + " | Salario: $" + salario;
    }
}