package by.kanarski.eshop.wrappers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class MimeElement {

    private String name;
    private byte[] content;
    private String contentType;

}
