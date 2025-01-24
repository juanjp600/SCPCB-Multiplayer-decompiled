Function mp_getserveraddress%(arg0$)
    Local local0%
    local0 = iptodecimal(arg0)
    If (local0 = $00) Then
        If (counthostips(arg0) > $00) Then
            local0 = hostip($01)
        EndIf
    EndIf
    Return local0
    Return $00
End Function
