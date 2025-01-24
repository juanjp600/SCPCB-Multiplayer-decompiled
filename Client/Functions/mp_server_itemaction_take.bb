Function mp_server_itemaction_take%(arg0.mp_player, arg1%)
    Local local0.items
    If (arg0\Field4\Field4 <> 0) Then
        Return $00
    EndIf
    If (arg1 < $3E8) Then
        local0 = mp_items[arg1]
        If ((((local0 <> Null) And (local0\Field15 = $00)) And (2.25 > entitydistancesquared(local0\Field2, arg0\Field18))) <> 0) Then
            mp_playertakeitem(arg0, local0)
        EndIf
    EndIf
    Return $00
End Function
