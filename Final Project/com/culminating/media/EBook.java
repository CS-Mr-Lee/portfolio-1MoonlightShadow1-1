/**
* Name(s): Franklin, Mike, Grace, Sophia
* Date: 2022-05-04
* Description: E-book class
*/

package com.culminating.media;

import java.time.LocalDate;
import java.time.LocalDateTime;
//imports Date
import java.util.Date;

public class EBook extends Book {
    public EBook() {
        super(); //inherits the default constructor of book
        this.setType("EBook");
    }

    /**
     * Constructor an EBook: sets publishDate, author, SIN, language, publisher, ageRating, genre, pages, and isbn from parameters
     * @param publishDate, the publish date of the EBook
     * @param author, the name of the author who wrote the EBook
     * @param SIN, the unique identity of the EBook
     * @param language, the language the EBook is written in
     * @param publisher, the Ebook's publisher's name
     * @param ageRating, the age rating of the EBook
     * @param genre, the genre of the EBook
     * @param pages, the number of pages the EBook has
     * @param isbn, the thirteen digit code of the EBook 
     */
    public EBook(String name, LocalDate publishDate, String author, int SIN, String language,
            String publisher, Character ageRating, String genre, int pages, int isbn, int checkOutNumber, int totalNumber, String imagePath, String description) {
        super(name, publishDate, author, SIN, language, publisher, ageRating, genre, pages, isbn, checkOutNumber, totalNumber, imagePath, description);
        this.setType("EBook");
    }
    
        
    /**
     * Description: prints all the attributes of the EBook
     * @return String all the attributes of the EBook
     */
    @Override
    public String toString() {
        return "{" +
                " publishDate='" + getPublishDate() + "'" +
                ", author='" + getAuthor() + "'" +
                ", SIN='" + getSIN() + "'" +
                ", language='" + getLanguage() + "'" +
                ", publisher='" + getPublisher() + "'" +
                ", ageRating='" + getAgeRating() + "'" +
                ", genre='" + getGenre() + "'" +
                ", pages='" + getPages() + "'" +
                ", isHardcover='" + getIsHardcover() + "'" +
                ", isbn='" + getIsbn() + "'" +
                "}";
    }
}
