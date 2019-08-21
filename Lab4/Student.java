public class Student implements java.io.Serializable{
    private int id;
    private float cpi;
    private String name, branch;
    
    public int getId()
    {
        return id;
    }

    public float getCpi()
    {
        return cpi;
    }

    public String getName()
    {
        return name;
    }

    public String getBranch()
    {
        return branch;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setCpi(float cpi)
    {
        this.cpi = cpi;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }
}