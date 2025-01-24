Function mp_client_receiveroomobject%(arg0%)
    Local local0.rooms
    Local local1%
    Local local2%
    Local local3.mp_roomobject
    local0 = mp_rooms[arg0]
    local1 = mp_readbyte()
    local2 = mp_readbyte()
    If (((local0 = Null) Lor (local0\Field11[local1] = $00)) <> 0) Then
        If (readbool(local2, $00) <> 0) Then
            mp_readfloat()
        EndIf
        If (readbool(local2, $01) <> 0) Then
            mp_readfloat()
        EndIf
        If (readbool(local2, $02) <> 0) Then
            mp_readfloat()
        EndIf
        If (readbool(local2, $03) <> 0) Then
            mp_readshort()
        EndIf
        If (readbool(local2, $04) <> 0) Then
            mp_readshort()
        EndIf
        If (readbool(local2, $05) <> 0) Then
            mp_readshort()
        EndIf
        Return $00
    EndIf
    local3 = local0\Field32[local1]
    If (local3 = Null) Then
        local0\Field32[local1] = (New mp_roomobject)
        local3 = local0\Field32[local1]
        local3\Field1 = local1
        local3\Field0 = local0
        local3\Field2 = entityx(local0\Field11[local1], $01)
        local3\Field3 = entityy(local0\Field11[local1], $01)
        local3\Field4 = entityz(local0\Field11[local1], $01)
        local3\Field5 = entitypitch(local0\Field11[local1], $01)
        local3\Field6 = entityyaw(local0\Field11[local1], $01)
        local3\Field7 = entityroll(local0\Field11[local1], $01)
    EndIf
    local3\Field8 = local3\Field2
    local3\Field9 = local3\Field3
    local3\Field10 = local3\Field4
    local3\Field11 = local3\Field5
    local3\Field12 = local3\Field6
    local3\Field13 = local3\Field7
    If (readbool(local2, $00) <> 0) Then
        local3\Field8 = mp_readfloat()
    EndIf
    If (readbool(local2, $01) <> 0) Then
        local3\Field9 = mp_readfloat()
    EndIf
    If (readbool(local2, $02) <> 0) Then
        local3\Field10 = mp_readfloat()
    EndIf
    If (readbool(local2, $03) <> 0) Then
        local3\Field11 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local2, $04) <> 0) Then
        local3\Field12 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local2, $05) <> 0) Then
        local3\Field13 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    Return $00
End Function
