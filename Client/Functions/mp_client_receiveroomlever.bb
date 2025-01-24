Function mp_client_receiveroomlever%(arg0%)
    Local local0.rooms
    Local local1%
    Local local2%
    Local local3.mp_roomlever
    local0 = mp_rooms[arg0]
    local1 = mp_readbyte()
    local2 = mp_readbyte()
    If (((local0 = Null) Lor (local0\Field13[local1] = Null)) <> 0) Then
        If (readbool(local2, $00) <> 0) Then
            mp_readshort()
        EndIf
        If (readbool(local2, $01) <> 0) Then
            mp_readshort()
        EndIf
        If (readbool(local2, $02) <> 0) Then
            mp_readshort()
        EndIf
        Return $00
    EndIf
    local3 = local0\Field33[local1]
    If (local3 = Null) Then
        local0\Field33[local1] = (New mp_roomlever)
        local3 = local0\Field33[local1]
        local3\Field1 = local1
        local3\Field0 = local0
        local3\Field2 = entitypitch(local0\Field13[local1]\Field0, $01)
        local3\Field3 = entityyaw(local0\Field13[local1]\Field0, $01)
        local3\Field4 = entityroll(local0\Field13[local1]\Field0, $01)
    EndIf
    local3\Field5 = local3\Field2
    local3\Field6 = local3\Field3
    local3\Field7 = local3\Field4
    If (readbool(local2, $00) <> 0) Then
        local3\Field5 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local2, $01) <> 0) Then
        local3\Field6 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    If (readbool(local2, $02) <> 0) Then
        local3\Field7 = convertshorttofloat(mp_readshort(), 10.0)
    EndIf
    Return $00
End Function
