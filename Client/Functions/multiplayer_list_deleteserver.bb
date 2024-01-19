Function multiplayer_list_deleteserver%(arg0.servers)
    If (selectserver = (Handle arg0)) Then
        selectserver = $FFFFFFFF
        servermenuopen = $00
    EndIf
    Delete arg0
    Return $00
End Function
