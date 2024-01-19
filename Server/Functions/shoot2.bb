Function shoot2%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5%)
    Local local0%
    createbullet($00, 0.6, arg0, arg1, arg2, arg3, arg4, arg5)
    For local0 = $01 To server\Field11 Step $01
        If (50.0 > distance3(arg0, arg1, arg2, entityx(playeroptimize[local0]\Field62, $00), entityy(playeroptimize[local0]\Field62, $00), entityz(playeroptimize[local0]\Field62, $00))) Then
            udp_writebyte($6B)
            udp_writebyte($00)
            udp_writeshort($00)
            udp_writefloat(arg0)
            udp_writefloat(arg1)
            udp_writefloat(arg2)
            udp_writefloat(arg3)
            udp_writefloat(arg4)
            udp_writebyte($00)
            udp_sendmessage(playeroptimize[local0]\Field30)
        EndIf
    Next
    Return $00
End Function
