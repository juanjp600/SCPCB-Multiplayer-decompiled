Function writeasdata%(arg0.bs)
    udp_writebytes(getbytestreamdata(compactbank[$00]), $00, getbytestreamdatasize(compactbank[$00]))
    Return $00
End Function
