Function mp_preparesendbuffer%(arg0.mp_netbuffer)
    mp_compressbuffer(arg0)
    writebytes(arg0\Field0, network\Field4, $00, arg0\Field2)
    Return $00
End Function
