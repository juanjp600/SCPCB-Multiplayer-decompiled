Function mp_server_itemaction_use%(arg0.mp_player)
    Local local0%
    Local local1%
    Local local2%
    Local local3.items
    Local local4.items
    If (arg0\Field4\Field4 <> 0) Then
        Return $00
    EndIf
    local0 = mp_readshort()
    local1 = mp_readshort()
    local2 = mp_readbyte()
    If (local0 < $3E8) Then
        local3 = mp_items[local0]
        If (((local3 <> Null) And (local3\Field27 = arg0\Field5)) <> 0) Then
            If (((local1 > $00) And (local1 < $3E8)) <> 0) Then
                local4 = mp_items[local1]
                If (((local4 <> Null) And (local4\Field27 = arg0\Field5)) = $00) Then
                    local4 = Null
                EndIf
            EndIf
            If (local2 <> 0) Then
                arg0\Field4\Field32 = local3
                mp_server_interactobject(arg0, $00, $02)
                arg0\Field4\Field32 = Null
            Else
                mp_server_onplayeruseitem(arg0, local3, local4)
            EndIf
            arg0\Field3 = (arg0\Field3 - $01)
            removeitem(local3)
        EndIf
    EndIf
    Return $00
End Function
