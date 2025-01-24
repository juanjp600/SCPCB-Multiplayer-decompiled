Function mp_server_itemaction_drop%(arg0.mp_player, arg1%)
    Local local0.items
    If (arg0\Field4\Field4 <> 0) Then
        Return $00
    EndIf
    If (arg1 < $3E8) Then
        local0 = mp_items[arg1]
        If (local0 <> Null) Then
            mp_dropplayeritem(arg0, local0)
            mp_assignitem(local0, Null)
        EndIf
    EndIf
    Return $00
End Function
