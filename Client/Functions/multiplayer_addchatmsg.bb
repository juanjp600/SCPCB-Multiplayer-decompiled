Function multiplayer_addchatmsg%(arg0$, arg1%)
    Local local0.chatmessage
    Local local1.players
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If (networkserver\Field18 <> 0) Then
        local0 = multiplayer_createmessage((nickname + arg0), $FFFFFFFF)
        For local1 = Each players
            If (local1\Field0 <> networkserver\Field28) Then
                udp_writebyte($0B)
                udp_writebyte($00)
                udp_writeline(local0\Field0)
                udp_writebyte($01)
                udp_sendmessage(local1\Field0)
            EndIf
        Next
    Else
        udp_bytestreamwritechar($0B)
        udp_bytestreamwriteline(arg0)
        udp_bytestreamwritechar(arg1)
        udp_setmicrobyte($0B)
    EndIf
    Return $00
End Function
