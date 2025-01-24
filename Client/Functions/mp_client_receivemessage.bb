Function mp_client_receivemessage%()
    Local local0$
    Local local1#
    Local local2%
    Local local3$
    Local local4$
    local0 = mp_readline()
    local1 = mp_readfloat()
    local2 = mp_readbyte()
    If (local2 = $00) Then
        createmsg(local0, local1)
    Else
        local3 = splitstring(local0, "::", $00)
        local4 = splitstring(local0, "::", $01)
        createmsg(getlocalstring(local3, local4), local1)
    EndIf
    Return $00
End Function
