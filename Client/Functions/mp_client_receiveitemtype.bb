Function mp_client_receiveitemtype%(arg0.items, arg1%)
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5%
    Local local6%
    Select arg0\Field25
        Case $01
            arg0\Field1 = mp_readline()
            arg0\Field0 = mp_readline()
            local1 = mp_readbyte()
            local2 = mp_readbyte()
            local3 = mp_readbyte()
            local4 = convertbytetofloat(mp_readbyte(), 100.0)
            If (((((arg0\Field6 <> local1) Lor (arg0\Field7 <> local2)) Lor (arg0\Field8 <> local3)) Lor (local4 <> arg0\Field9)) <> 0) Then
                arg0\Field6 = local1
                arg0\Field7 = local2
                arg0\Field8 = local3
                arg0\Field9 = local4
                If (countchildren(arg0\Field3) > $00) Then
                    entitycolor(getchild(arg0\Field3, $01), (Float arg0\Field6), (Float arg0\Field7), (Float arg0\Field8))
                    entityalpha(getchild(arg0\Field3, $01), (Abs arg0\Field9))
                EndIf
            EndIf
            arg0\Field12 = (Float mp_readshort())
        Case $02
            If (arg1 = mp_getmyindex()) Then
                Repeat
                    local6 = mp_readshort()
                    If (local6 = $00) Then
                        Exit
                    EndIf
                    mp_client_receiveitemchild(local6, arg0)
                    local5 = $01
                Forever
            Else
                local5 = (mp_readbyte() = $00)
            EndIf
            mp_refreshanimatedbag(arg0, local5)
        Case $03,$05
            If (arg1 = mp_getmyindex()) Then
                arg0\Field12 = (Float mp_readshort())
            EndIf
        Case $04
            setanimtime(arg0\Field3, (Float mp_readbyte()), $00)
    End Select
    Return $00
End Function
