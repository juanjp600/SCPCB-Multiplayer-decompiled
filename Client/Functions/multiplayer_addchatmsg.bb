Function multiplayer_addchatmsg%(arg0$, arg1%)
    Local local0.chatmessage
    Local local1.players
    If (udp_getstream() = $00) Then
        Return $00
    EndIf
    If (networkserver\Field15 <> 0) Then
        local0 = multiplayer_createmessage((nickname + arg0), $FFFFFFFF)
        For local1 = Each players
            If (local1\Field0 <> networkserver\Field20) Then
                udp_writebyte($0B)
                udp_writebyte($00)
                udp_writeline(local0\Field0)
                udp_writebyte($01)
                udp_sendmessage(local1\Field0)
            EndIf
        Next
    Else
        udp_writebyte($0B)
        udp_writebyte(networkserver\Field20)
        udp_writeline(arg0)
        udp_writebyte(arg1)
        udp_sendmessage($00)
    EndIf
    Return $00
End Function
