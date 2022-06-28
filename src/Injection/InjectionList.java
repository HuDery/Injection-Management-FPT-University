package Injection;

import Students_Vaccine.Student;
import Students_Vaccine.Vaccine;
import java.util.ArrayList;
import Input.Input;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

public class InjectionList {

    ArrayList<Injection> listInjection = new ArrayList();
    ArrayList<Student> listStudent = new ArrayList();
    ArrayList<Vaccine> listVaccine = new ArrayList();

    ////////////////////////////////////////////////////////////////////////////////////// Ghi file Studen and Vaccine
    public void writeStudent() {
        try {
            String fileName = "student.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            listStudent.add(new Student("SE1500", "Le Ha Duy"));
            listStudent.add(new Student("SE1501", "Nguyen Bao Toan"));
            listStudent.add(new Student("SE1502", "Huynh Ngo Gia Bao"));
            listStudent.add(new Student("SE1503", "Pham Phu Hung"));
            listStudent.add(new Student("SE1505", "Nguyen Cong Huy"));
            listStudent.add(new Student("SE1506", "Pham Ha Giang"));
            listStudent.add(new Student("SE1507", "Lu Thuan Loi"));
            listStudent.add(new Student("SE1508", "Vo Duc Nam"));
            listStudent.add(new Student("SE1509", "Vo Tran Duy Long"));
            listStudent.add(new Student("SE1510", "Tran Anh Khoi"));
            oStream.writeObject(listStudent);
            oStream.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Write file student failed !!");
        }
    }

    public void writeVaccine() {
        try {
            String fileName = "vaccine.dat";
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oStream = new ObjectOutputStream(file);
            listVaccine.add(new Vaccine("Covid-V001", "AstraZeneca"));
            listVaccine.add(new Vaccine("Covid-V002", "SPUTNIK V"));
            listVaccine.add(new Vaccine("Covid-V003", "Vero Cell"));
            listVaccine.add(new Vaccine("Covid-V004", "Pfizer"));
            listVaccine.add(new Vaccine("Covid-V005", "Moderna"));
            oStream.writeObject(listVaccine);
            oStream.close();
            file.close();
        } catch (Exception e) {
            System.out.println("write file vaccine false!");
        }
    }

    public InjectionList() {
        super();
        writeStudent();
        writeVaccine();
    }

//////////////////////////////////////////////////////////////////////////////////////// Doc file Student va Vaccine
    public void printAllStudent() {
        try {
            FileInputStream file = new FileInputStream("student.dat");
            ObjectInputStream ist = new ObjectInputStream(file);
            ist.readObject();
            ist.close();
            file.close();
        } catch (Exception e) {
            System.out.println("Empty list");
        }
        for (Student st : listStudent) {
            System.out.println(st);
        }
    }

////////////////////////////////////////////////////////////////////////////////////////// Search All ID
    public Injection searchInjectionID(String injID) {
        for (int i = 0; i < listInjection.size(); i++) {
            if (listInjection.get(i).getInjectionID().equals(injID)) {
                return listInjection.get(i);
            }
        }
        return null;
    }

    public Student searchStudentbyID(String stID) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getStudentID().equals(stID)) {
                return listStudent.get(i);
            }
        }
        return null;
    }

    public Vaccine searchVaccinebyID(String vcID) {
        for (int i = 0; i < listVaccine.size(); i++) {
            if (listVaccine.get(i).getVaccineID().equals(vcID)) {
                return listVaccine.get(i);
            }
        }
        return null;
    }

    public int ChooseInjectionIDtoUP(String injID) {
        for (int i = 0; i < listInjection.size(); i++) {
            if (listInjection.get(i).getInjectionID().equals(injID)) {
                return i;
            }
        }
        return -1;
    }

    public int chooseStudentIDtoCheckInjection(String stID) {
        for (int i = 0; i < listInjection.size(); i++) {
            if (listInjection.get(i).studentID.equals(stID)) {
                return 1;
            }
        }
        return -1;
    }

////////////////////////////////////////////////////////////////////////////////////////// Tao Bien kiem tra
    boolean ktrInjectionID = false;
    boolean ktrStudentID = false;
    boolean ktrVaccineID = false;
    long ktrdate2;

//////////////////////////////////////////////////////////////////////////////////////////// ADD Injection
    public void addInjection() {
        String newinjectionID;
        String newStudentID;
        String newVaccineID;
        String newdate1;
        String newplace1;
        String newplace2 = null;
        String newdate2 = null;
        boolean mui1 = false;
        boolean mui2 = false;
        boolean ask;
        int ktr;

        do {
            // Nhap Injection
            do {
                newinjectionID = Input.inputstring("Enter injectionID: ", "--> InjectionID can not be empty!!!");
                ktrInjectionID = searchInjectionID(newinjectionID) != null;
                if (ktrInjectionID) {
                    System.out.println("--> InjectionID is duplicated!!!");
                }
            } while (ktrInjectionID == true);

            // Nhap ID Student
            System.out.println("---Student List---");
            for (Student st : listStudent) {
                System.out.println(st);
            }
            do {
                newStudentID = Input.inputstring("Enter StudentID from the list above [ SE150x (x from 0 to 5) ]: ", "--> StudentID can not be empty");
                ktrStudentID = searchStudentbyID(newStudentID) == null;

                if (ktrStudentID) {
                    System.out.println("--> StudentID not exist");
                    System.out.println("--> Please input Student ID is [ SE150x (x from 0 to 5) ]");
                }

                ktr = chooseStudentIDtoCheckInjection(newStudentID);
                if (ktr == 1) {
                    System.out.println("--> Student have been 1st injection");
                }
            } while (ktrStudentID || ktr == 1);

            //Nhap place1,date1
            newplace1 = Input.inputstring("Enter the place of the first vaccination: ", "--> Place can not be empty!!!");
            newdate1 = Input.inputDate1();

            // Nhap ID vaccine
            System.out.println("---Vaccine List---");
            for (Vaccine vc : listVaccine) {
                System.out.println(vc);
            }
            do {
                newVaccineID = Input.inputstring("Ente VaccineID from the list above [ Covid-V00x (x from 0 to 5) ]: ", "--> VaccineID can not be empty");
                ktrVaccineID = searchVaccinebyID(newVaccineID) == null;
                if (ktrVaccineID) {
                    System.out.println("--> Vaccine ID not exist");
                    System.out.println("--> please input Vaccine ID is [ Covid-V00x (x from 0 to 5) ]");
                }
            } while (ktrVaccineID);

            // Nhap mui1
            mui1 = true;

            Injection in = new Injection(newinjectionID, newStudentID, newplace1, newdate1, newVaccineID, mui1, newplace2, newdate2, mui2);

            if (listInjection.add(in) == true) {
                System.out.println("-- Added Successfully --");
            }
            
            Input s = new Input();
            System.out.println("Are you want to continue create new injection?");
            ask = s.askmenu();
        } while (ask == true);
    }

///////////////////////////////////////////////////////////////////////////////////////////// UPDATE Injection
    public void updateInjectionbyID() {
        String newinjectionID;
        String newplace2;
        String newdate2;
        int ktr;
        if (listInjection.isEmpty()) {
            System.out.println("Empty List!!");
        } else {
            do {
                // S1 SE1500 LHD DT 20/11/2021 True null null false
                newinjectionID = Input.inputstring("Enter injectionID to update: ", "--> Injection can not be empty!!!");
                ktr = ChooseInjectionIDtoUP(newinjectionID);
                if (ktr == -1) {
                    System.out.println("InjectionID not exist!!!");
                } else if (listInjection.get(ktr).isMui1() == false) {
                    System.out.println("Student does not have 1st Injection!!");
                } else if (listInjection.get(ktr).isMui2() == true) {
                    System.out.println("Students have received 2 injections!!");
                } else {
                    newplace2 = Input.inputstring("Enter the place of the seconnd vaccination: ", "--> Place can not be empty!!!");
                    do {
                        System.out.println("--> Please only input 2nd injection must be 4 weeks or 12 weeks older than 1st injection <--");
                        newdate2 = Input.inputDate2();
                        try {
                            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                            ktrdate2 = (sd.parse(newdate2).getTime() - sd.parse(listInjection.get(ktr).getDate1()).getTime()) / (24 * 3600 * 1000);
                            if (ktrdate2 < 28 || ktrdate2 > 84) {
                                System.out.println("--> 2nd vaccine must be given 4 to 12 weeks after the 1st injection !!");
                            }
                        } catch (Exception e) {
                        }
                    } while (ktrdate2 < 28 || ktrdate2 > 84);
                    listInjection.get(ktr).setPlace2(newplace2);
                    listInjection.get(ktr).setDate2(newdate2);
                    listInjection.get(ktr).setMui2(true);
                    System.out.println("-- Update successfully!! --");
                }
            } while (ktr == -1);
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////// REMOVE Injection
    public void deletedbyInjectionID() {
        String newinjectionID;
        boolean ask;
        if (listInjection.isEmpty()) {
            System.out.println("Empty list!");
        } else {
            newinjectionID = Input.inputstring("Enter InjectionID to delete: ", "--> InjectionID can not be empty!");
            Injection inj = searchInjectionID(newinjectionID);
            if (inj != null) {
                Input s = new Input();
                System.out.println("Are you want to remove this injectionID?");
                ask = s.askmenu();
                if (ask) {
                    listInjection.remove(inj);
                    System.out.println("-- Remove successfully --");
                } else {
                    System.out.println("-- Remove fail --");
                }
            } else {
                System.out.println("This injection have ID is " + "[" + newinjectionID + "]" + " does not exist");
            }
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////// SEARCH injection
    public void searchAllInforStudent() {
        Injection in = new Injection();
        String studentID;
        boolean check = false;
        if (listInjection.isEmpty()) {
            System.out.println("Empty list");
        } else {
            studentID = Input.inputstring("Enter StudentID to search: ", "--> StudentID can not be empty!");
            for (int i = 0; i < listInjection.size(); i++) {
                if (listInjection.get(i).getStudentID().equals(studentID)) {
                    in.outputTable();
                    System.out.println(listInjection.get(i));
                    System.out.println("|---------------------------------------------------------------------------------------------------------------------------------------|");
                    check = true;
                }

            }
            if (!check) {
                System.out.println("Student have ID is " + "[" + studentID + "]" + " dose not exist");
            }
        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void saveFile(String filename) {
        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Injection inj : listInjection) {
                bw.write(inj.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("-- File [ Injections.dat ] Saved!!! --");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
