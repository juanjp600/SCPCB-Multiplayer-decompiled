Function server_playerrecv%(arg0.mp_player)
    Local local0%
    If (arg0\Field4\Field4 <> 0) Then
        mp_ignorebytes($0C)
    Else
        arg0\Field7 = mp_readfloat()
        arg0\Field8 = mp_readfloat()
        arg0\Field9 = mp_readfloat()
    EndIf
    arg0\Field10 = convertshorttofloat(mp_readshort(), 10.0)
    arg0\Field11 = convertshorttofloat(mp_readshort(), 10.0)
    arg0\Field14 = (Int min((Float mp_readbyte()), 19.0))
    arg0\Field22 = mp_readbyte()
    arg0\Field21 = mp_readbyte()
    arg0\Field4\Field17 = mp_readbyte()
    arg0\Field4\Field2 = (Float mp_readbyte())
    arg0\Field4\Field14 = (Float mp_readshort())
    arg0\Field4\Field18 = readbool(arg0\Field21, $02)
    If (readbool(arg0\Field21, $00) <> 0) Then
        arg0\Field28 = rnd(1.0, 2.0)
    EndIf
    If (readbool(arg0\Field21, $01) <> 0) Then
        arg0\Field28 = rnd(2.0, 4.5)
    EndIf
    arg0\Field4\Field20 = $00
    If (readbool(arg0\Field21, $03) <> 0) Then
        arg0\Field4\Field19 = $00
        arg0\Field4\Field20 = mp_readbyte()
        arg0\Field4\Field21 = mp_readbyte()
        arg0\Field4\Field22 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(arg0\Field21, $04) <> 0) Then
        arg0\Field4\Field19 = $01
        arg0\Field4\Field20 = mp_readbyte()
        arg0\Field4\Field21 = mp_readbyte()
        arg0\Field4\Field22 = convertshorttofloat(mp_readshort(), 10.0)
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
    For local0 = $00 To $04 Step $01
        arg0\Field4\Field23[local0] = mp_readshort()
    Next
    Return $00
End Function
