Function client_recvownplayerdata%()
    Local local0%
    Local local1#
    Local local2#
    local0 = mp_readbyte()
    If (0.0 >= mp_terminated\Field6) Then
        If ((local0 And (0.0 = me\Field0)) <> 0) Then
            kill($00, $00, $01, $01)
        ElseIf (local0 = $00) Then
            mp_respawnplayer(ue_players[mp_getmyindex()])
        EndIf
    EndIf
    me\Field31 = convertshorttofloat(mp_readshort(), 10.0)
    me\Field32 = convertshorttofloat(mp_readshort(), 10.0)
    local1 = convertshorttofloat(mp_readshort(), 10.0)
    If (((((0.0 = me\Field0) And (20.0 <= (Abs (local1 - me\Field10)))) And (((-20.0 <= me\Field10) And (0.0 >= me\Field10)) = $00)) And (0.0 >= me\Field16)) <> 0) Then
        me\Field10 = local1
    EndIf
    me\Field11 = convertshorttofloat(mp_readshort(), 10.0)
    me\Field13 = convertshorttofloat(mp_readshort(), 10.0)
    me\Field12 = convertshorttofloat(mp_readshort(), 10.0)
    me\Field15 = (Float mp_readshort())
    local2 = (Float mp_readshort())
    If (30.0 <= (Abs (local2 - i_268\Field1))) Then
        i_268\Field1 = local2
    EndIf
    i_268\Field3 = (Float mp_readshort())
    chs\Field0 = mp_readbyte()
    Return $00
End Function
