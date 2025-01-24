Function mp_client_receivesound%()
    Local local0%
    Local local1$
    Local local3%
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    local0 = mp_readbyte()
    local1 = mp_readline()
    Select local0
        Case $01
            local3 = mp_readbyte()
            local4 = mp_readfloat()
            local5 = mp_readfloat()
            If (local3 = $00) Then
                local6 = mp_readfloat()
                local7 = mp_readfloat()
                local8 = mp_readfloat()
            EndIf
            mp_playsound(local1, local4, local5, $00, $00, $01, local3, local6, local7, local8)
        Case $02
            mp_playlocalsound(local1, 1.0, $01)
    End Select
    Return $00
End Function
