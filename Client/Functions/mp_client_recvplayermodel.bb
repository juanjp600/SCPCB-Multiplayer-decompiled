Function mp_client_recvplayermodel%(arg0.mp_player)
    Local local0.mp_playermodel
    Local local1%
    Local local2%
    Local local3#
    Local local4#
    Local local5%
    Local local6%
    Local local7%
    local0 = arg0\Field35
    local1 = mp_readbyte()
    local2 = mp_readbyte()
    local3 = mp_readfloat()
    local4 = mp_readfloat()
    local5 = mp_readbyte()
    If (local5 > $00) Then
        mp_client_receivecorpse(local5, arg0\Field5)
    EndIf
    local6 = $00
    local6 = (local6 + ((local0\Field17 <> local1) Lor (local0\Field18 <> local2)))
    local6 = (local6 + ((local3 <> local0\Field20) Lor (local4 <> local0\Field19)))
    If (local6 > $00) Then
        setplayermodel(arg0, local1, $00)
        local0\Field18 = local2
        local0\Field20 = local3
        local0\Field19 = local4
        flushplayermodel(arg0)
    EndIf
    For local7 = $00 To $09 Step $01
        setplayerattachmodel(arg0, local7, mp_readbyte())
    Next
    Return $00
End Function
