package src;



public class complaint {
    private String studentId;
    private String description;
    private String status;
    private String date;
    private static String complaintid;

    public complaint(String studentId, String description){
        this.complaintid = complaintid;
        this.studentId=studentId;
        this.description=description;
        this.status="Pending;";
        this.date=date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId= studentId;
    }

    public String getComplaintId() {
        return complaintid;
    }

    public void setComplaintId(String complaintid) {
        this.complaintid = complaintid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        this.status=status;
    }


    public void resolve(){
        this.status = "Resolved";
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date){
        this.date=date;

        return date;
    }

    @Override
    public String toString(){
        return "StudentID:" + studentId + "Description" + description + "Status" + status ;

    }
}
