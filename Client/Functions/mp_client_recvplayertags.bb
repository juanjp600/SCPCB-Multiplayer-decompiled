Function mp_client_recvplayertags%(arg0.mp_player)
    Local local0%
    Local local1$
    Local local2#
    Local local3#
    Local local4#
    Local local5%
    Local local6%
    For local0 = $02 To $04 Step $01
        setplayertagtext(arg0, local0, mp_readline())
        If (len(arg0\Field34[local0]\Field2) > $00) Then
            local1 = mp_readline()
            local2 = mp_readfloat()
            local3 = mp_readfloat()
            local4 = mp_readfloat()
            local5 = mp_readint()
            local6 = mp_readint()
            setplayertagfont(arg0, local0, local1)
            setplayertagscale(arg0, local0, local2, local3)
            setplayertagoffset(arg0, local0, local4)
            setplayertagcolors(arg0, local0, local5, local6)
        EndIf
    Next
    Return $00
End Function
