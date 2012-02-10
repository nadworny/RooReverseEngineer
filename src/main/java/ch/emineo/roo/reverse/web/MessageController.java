package ch.emineo.roo.reverse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.emineo.roo.reverse.domain.Message;

@RequestMapping("/messages")
@Controller
@RooWebScaffold(path = "messages", formBackingObject = Message.class)
public class MessageController {

	Logger logger = LoggerFactory.getLogger(MessageController.class);

	@RequestMapping(produces = "text/html")
	public String list(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {
		logger.info("Inside list.");
		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			final int firstResult = page == null ? 0 : (page.intValue() - 1)
					* sizeNo;
			logger.info("SizeNo: " + sizeNo + ", firstResult: " + firstResult);
			uiModel.addAttribute("messages",
					Message.findMessageEntries(firstResult, sizeNo));
			float nrOfPages = (float) Message.countMessages() / sizeNo;
			uiModel.addAttribute(
					"maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1
							: nrOfPages));
		} else {
			logger.info("No paging");
			uiModel.addAttribute("messages", Message.findAllMessages());
		}
		addDateTimeFormatPatterns(uiModel);
		return "messages/list";
	}
}
