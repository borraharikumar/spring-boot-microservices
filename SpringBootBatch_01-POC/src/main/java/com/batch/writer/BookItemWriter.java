package com.batch.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class BookItemWriter implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		System.err.println("BookItemWriter.write()");
		
		chunk.forEach(item->{
			System.out.println(item);
		});
	}

}
