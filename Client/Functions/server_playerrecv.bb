Function server_playerrecv%(arg0.mp_player)
    arg0\Field4\Field38 = $01
    arg0\Field4\Field40 = mp_readfloat()
    arg0\Field4\Field41 = mp_readfloat()
    arg0\Field4\Field42 = mp_readfloat()
    arg0\Field10 = convertshorttofloat(mp_readshort(), 10.0)
    arg0\Field11 = convertshorttofloat(mp_readshort(), 10.0)
    arg0\Field14 = mp_readbyte()
    arg0\Field22 = mp_readbyte()
    arg0\Field21 = mp_readbyte()
    arg0\Field4\Field17 = mp_readbyte()
    arg0\Field4\Field2 = (Float mp_readbyte())
    arg0\Field4\Field14 = (Float mp_readshort())
    arg0\Field4\Field20 = $00
    If (readbool(arg0\Field21, $03) <> 0) Then
        arg0\Field4\Field20 = mp_readbyte()
        arg0\Field4\Field21 = mp_readbyte()
        arg0\Field4\Field22 = convertshorttofloat(mp_readshort(), 10.0)
        arg0\Field4\Field19 = readbool(arg0\Field21, $04)
    EndIf
    arg0\Field4\Field24 = $00
    If (readbool(arg0\Field21, $05) <> 0) Then
        arg0\Field4\Field24 = mp_readbyte()
        arg0\Field4\Field25 = mp_readshort()
    EndIf
    arg0\Field4\Field27 = $00
    If (readbool(arg0\Field21, $06) <> 0) Then
        arg0\Field4\Field27 = mp_readshort()
    EndIf
    mp_readbytes(arg0\Field4\Field39, $0A, $00)
    Return $00
End Function
