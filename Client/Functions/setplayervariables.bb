Function setplayervariables%()
    Local local0.breachtypes
    local0 = getbreachtype(myplayer\Field51)
    myplayer\Field24 = nickname
    myplayer\Field33 = player_isdead()
    myplayer\Field1 = entityx(collider, $00)
    myplayer\Field2 = entityy(collider, $00)
    myplayer\Field3 = entityz(collider, $00)
    myplayer\Field4 = entityyaw(camera, $00)
    myplayer\Field5 = entitypitch(camera, $00)
    myplayer\Field55 = player_move
    myplayer\Field31 = blinktimer
    If (outscp = $00) Then
        myplayer\Field4 = savedangle
    EndIf
    myplayer\Field40 = (wearinghazmat <> $00)
    myplayer\Field39 = (wearingnightvision <> $00)
    myplayer\Field38 = (wearinggasmask <> $00)
    myplayer\Field41 = (wearingvest <> $00)
    If (((-180.0 = local0\Field53) Or (local0\Field1 = haos_model)) <> 0) Then
        myplayer\Field79 = (((((((myplayer\Field40 + (myplayer\Field39 Shl $01)) + (myplayer\Field38 Shl $02)) + (myplayer\Field41 Shl $03)) + ((0.0 > gunroll) Shl $04)) + (myplayer\Field83 Shl $05)) + (myplayer\Field82 Shl $06)) + ((0.0 < gunroll) Shl $07))
    Else
        myplayer\Field79 = (((((((myplayer\Field40 + (myplayer\Field39 Shl $01)) + (myplayer\Field38 Shl $02)) + (myplayer\Field41 Shl $03)) + ((0.0 < gunroll) Shl $04)) + (myplayer\Field83 Shl $05)) + (myplayer\Field82 Shl $06)) + ((0.0 > gunroll) Shl $07))
    EndIf
    myplayer\Field36 = playersoundvolume
    myplayer\Field35 = crouchstate
    myplayer\Field37 = holdinggun
    myplayer\Field46 = playerroom\Field7\Field11
    myplayer\Field47 = playerroom\Field65
    myplayer\Field72 = ((((((myplayer\Field43 + (isgunsighting() Shl $01)) + (voice\Field4 Shl $02)) + (menuopen Shl $03)) + (myplayer\Field33 Shl $04)) + (gameload Shl $05)) + (myplayer\Field52 Shl $06))
    myplayer\Field68 = getitemid(selecteditem)
    If (networkserver\Field60 <> 0) Then
        networkserver\Field59 = $00
    EndIf
    If (networkserver\Field15 = $00) Then
        myplayer\Field70 = (100.0 - (injuries * 10.0))
    EndIf
    Return $00
End Function
