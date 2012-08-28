package model.bean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import model.entity.ProductCategorys;
import model.entity.ProductDetails;
import model.session.ProductDetailsFacade;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author HAO HAO
 */
@ManagedBean
@SessionScoped
public class FileUploadBean {

    @EJB
    private ProductDetailsFacade productDetailsFacade;

    /** Creates a new instance of FileUploadBean */
    public FileUploadBean() {
    }
    private int cateChange;

    public int getCateChange() {
        return cateChange;
    }

    public void setCateChange(int cateChange) {
        this.cateChange = cateChange;
    }
    ProductDetails pdn = new ProductDetails();

    public ProductDetails getPdn() {
        return pdn;
    }

    public void setPdn(ProductDetails pdn) {
        this.pdn = pdn;
    }

    public String addProduct() {
        pdn.setProductCategorys(new ProductCategorys(cateChange));
        pdn.setStatus(Boolean.TRUE);
        pdn.setFigure(file.getFileName());
        productDetailsFacade.addProductdetail(pdn);
        return "products";
    }
    
    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

    public void fileUpload(FileUploadEvent event) {
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String homeDir = context.getRealPath("");
        StringBuffer str = new StringBuffer(homeDir);
        String fileDir = str.substring(0, str.lastIndexOf("ALL_Project"));
        FileOutputStream fos = null;
        try {
            file = event.getFile();
            byte[] buff = file.getContents();
            img = file.getFileName();
            File f = new File(fileDir + "/ALL_Project/web/img/p/" + file.getFileName());
            if (!f.exists()) {
                f.createNewFile();
            }
            fos = new FileOutputStream(f);
            fos.write(buff);
            fos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUploadBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
