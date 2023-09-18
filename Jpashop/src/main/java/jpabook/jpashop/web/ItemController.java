package jpabook.jpashop.web;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @GetMapping("/items/new")
  public String createForm(Model model) {
    model.addAttribute("form", new BookForm());
    //model.addAttribute("form", new AlbumForm());
    return "items/createItemForm";
  }


  @PostMapping("/items/new")
  public String create(BookForm form/*, AlbumForm albumForm*/) {

    Book book = getBook(form);

    itemService.saveItem(book);
    return "redirect:/";


    /*if (albumForm != null) {
      Album album = new Album();
      album.setName(albumForm.getName());
      album.setPrice(albumForm.getPrice());
      album.setStockQuantity(albumForm.getStockQuantity());
      album.setArtist(albumForm.getArtist());
      album.setEtc(albumForm.getEtc());
      itemService.saveItem(album);
    }
    return "redirect:/";
  }*/
  }

  private static Book getBook(BookForm form) {
    Book book = new Book();
    book.setName(form.getName());
    book.setPrice(form.getPrice());
    book.setStockQuantity(form.getStockQuantity());
    book.setAuthor(form.getAuthor());
    book.setIsbn(form.getIsbn());
    return book;
  }

  /**
   * 상품 목록 조회
   */
  @GetMapping(value = "/items")
  public String list(Model model) {
    List<Item> items = itemService.findItems();
    model.addAttribute("items", items);
    return "items/itemList";
  }

  /**
   * 상품 수정 폼
   */

  @GetMapping(value = "/items/{itemId}/edit")
  public String updateItemForm(@PathVariable("itemId") Long itemId, Model model){
    Book item = (Book) itemService.findOne(itemId);

    BookForm form = new BookForm();
    form.setId(item.getId());
    form.setName(item.getName());
    form.setPrice(item.getPrice());
    form.setStockQuantity(item.getStockQuantity());
    form.setAuthor(item.getAuthor());
    form.setIsbn(item.getIsbn());

    model.addAttribute("form", form);
    return "items/updateItemForm";
  }

  /**
   * 상품 수정
   */
  @PostMapping(value = "/items/{itemId}/edit")
  public String updateItem(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) { //
  /*  Book book = new Book();
    book.setId(form.getId());
    book.setName(form.getName());
    book.setPrice(form.getPrice());
    book.setStockQuantity(form.getStockQuantity());
    book.setAuthor(form.getAuthor());
    book.setIsbn(form.getIsbn());
    itemService.saveItem(book);
    return "redirect:/items"; */

    //어설프게 엔티티를 파라미터로 쓰지않고 필요한 데이터만 받음 -> 유지보수에 용이
    itemService.updateItem(itemId,form.getName(), form.getPrice(), form.getStockQuantity());

    return "redirect:/items";
  }
}

