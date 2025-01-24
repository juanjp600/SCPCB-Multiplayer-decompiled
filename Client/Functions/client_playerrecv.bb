Function client_playerrecv%(arg0%)
    Local local0.mp_player
    Local local1%
    If (ue_players[arg0] = Null) Then
        initializeplayer(arg0, $00, $00)
    EndIf
    local0 = ue_players[arg0]
    local0\Field20 = $01
    local0\Field16 = mp_readbyte()
    local1 = mp_readbyte()
    If (mp_getmyindex() = arg0) Then
        mp_ignorebytes(((readbool(local1, $04) Shl $01) + $12))
        Return $00
    EndIf
    local0\Field7 = mp_readfloat()
    local0\Field8 = mp_readfloat()
    local0\Field9 = mp_readfloat()
    local0\Field10 = convertshorttofloat(mp_readshort(), 10.0)
    local0\Field11 = convertshorttofloat(mp_readshort(), 10.0)
    local0\Field14 = mp_readbyte()
    local0\Field22 = mp_readbyte()
    local0\Field21 = local1
    local0\Field29 = readbool(local0\Field21, $00)
    If (readbool(local0\Field21, $01) <> 0) Then
        local0\Field28 = rnd(1.0, 2.0)
    EndIf
    If (readbool(local0\Field21, $02) <> 0) Then
        local0\Field28 = rnd(2.0, 4.5)
    EndIf
    local0\Field30 = readbool(local0\Field21, $03)
    local0\Field26 = $00
    If (readbool(local0\Field21, $04) <> 0) Then
        local0\Field26 = mp_readshort()
    EndIf
    local0\Field31 = $00
    If (readbool(local0\Field21, $05) <> 0) Then
        local0\Field31 = $01
    EndIf
    If (readbool(local0\Field21, $06) <> 0) Then
        local0\Field31 = $02
    EndIf
    Return $00
End Function
