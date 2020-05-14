package ma.dxc.orchestration;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;

import java.lang.reflect.Type;

import ma.dxc.dto.ContactDTO;
import ma.dxc.model.Contact;

public class ContactMapperImpl implements ContactMapper {
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ContactDTO toContactDTO(Contact contact) {
		return modelMapper.map(contact, ContactDTO.class);
	}

	@Override
	public List<ContactDTO> toContactDTOs(List<Contact> contacts) {
		
		Type listType = new TypeToken<List<ContactDTO>>(){}.getType();
		List<ContactDTO> contactDTOs = modelMapper.map(contacts,listType);
		
		return contactDTOs;
	}

	@Override
	public Contact toContact(ContactDTO contactDTO) {
		return modelMapper.map(contactDTO, Contact.class);
	}

	@Override
	public Page<ContactDTO> toContactDTOsPageable(Page<Contact> contacts) {
		
		Type listType = new TypeToken<Page<ContactDTO>>(){}.getType();
		Page<ContactDTO> contactDTOsPageable = modelMapper.map(contacts,listType);
		return contactDTOsPageable;
	}

}
