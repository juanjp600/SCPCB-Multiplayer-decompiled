Function playannouncement%(arg0$, arg1%)
    Local local0%
    If (getscripts() <> 0) Then
        public_inqueue($37, $00)
        public_addparam($00, arg0, $03)
        callback($00)
    EndIf
    If (arg1 = $00) Then
        Return $00
    EndIf
    For local0 = $01 To server\Field18 Step $01
        If (player[local0] <> Null) Then
            udp_writebyte($09)
            udp_writebyte($01)
            udp_writeline(arg0)
            udp_sendmessage(local0)
        EndIf
    Next
    Return $00
End Function
