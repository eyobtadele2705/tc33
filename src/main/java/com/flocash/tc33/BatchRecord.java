package com.flocash.tc33;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flocash.tc33.records.BatchTrailerRecord;
import com.flocash.tc33.records.FileHeader;
import com.flocash.tc33.records.FileTrailer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class BatchRecord {

    FileHeader fileHeader;
    List<Transaction> transactions;
    FileTrailer fileTrailer;
    BatchTrailerRecord batchTrailerRecord;

}
