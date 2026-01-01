package com.flocash.tc33;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.flocash.tc33.records.FileHeaderRecord;
import com.flocash.tc33.records.FileHeaderRecordIncoming;
import com.flocash.tc33.records.FileTrailerRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class Wrapper {

    private FileHeaderRecordIncoming fileHeaderRecordIncoming;
    @JsonInclude(NON_DEFAULT)
    private FileHeaderRecord fileHeaderRecord;
    private List<BatchRecord> batchRecords;
    private FileTrailerRecord fileTrailerRecord;
}
