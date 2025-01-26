Function mp_server_itemaction_assigning%(arg0.mp_player)
    Local local0%
    Local local1%
    Local local2.items
    Local local3.items
    If (arg0\Field4\Field4 <> 0) Then
        Return $00
    EndIf
    local0 = mp_readshort()
    local1 = mp_readshort()
    If (((local0 < $3E8) And (local1 < $3E8)) <> 0) Then
        local2 = mp_items[local0]
        local3 = mp_items[local1]
        If (((((((local2 <> Null) And (local3 <> Null)) And (local2\Field27 = arg0\Field5)) And (local3\Field27 = arg0\Field5)) And (mp_items[local2\Field26] = Null)) And mp_pushitemtosecondinv(local2, local3)) <> 0) Then
            mp_assignitem(local2, local3)
            arg0\Field3 = (arg0\Field3 - $01)
        EndIf
    EndIf
    Return $00
End Function
