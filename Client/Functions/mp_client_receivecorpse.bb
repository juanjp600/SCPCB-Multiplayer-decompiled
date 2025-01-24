Function mp_client_receivecorpse%(arg0%, arg1%)
    Local local0.mp_playercorpse
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10%
    local0 = mp_corpses[arg0]
    local1 = mp_readbyte()
    local2 = mp_readbyte()
    local3 = mp_readbyte()
    local4 = mp_readbyte()
    local5 = mp_readfloat()
    local6 = mp_readfloat()
    local7 = mp_readfloat()
    local8 = convertshorttofloat(mp_readshort(), 10.0)
    local9 = mp_readfloat()
    If ((((local0 = Null) Lor (local0\Field3 <> local3)) Lor (local0\Field4 <> local4)) <> 0) Then
        If (local0 <> Null) Then
            mp_flushcorpse(local0)
        EndIf
        local0 = mp_createcorpse(local5, local6, local7, local8, local3, local4, Null, (20860.0 > local9), local2, arg0)
    EndIf
    If (140.0 < (Abs (local9 - local0\Field10))) Then
        local0\Field10 = local9
    EndIf
    If (readbool(local1, $00) <> 0) Then
        For local10 = $00 To $09 Step $01
            mp_setcorpseattachmodel(local0, local10, findattachmodel(mp_readbyte()))
        Next
    ElseIf (local0\Field12 > $00) Then
        For local10 = $00 To $09 Step $01
            mp_setcorpseattachmodel(local0, local10, Null)
        Next
    EndIf
    local0\Field14 = readbool(local1, $01)
    local0\Field11 = arg1
    local0\Field13 = $01
    Return $00
End Function
