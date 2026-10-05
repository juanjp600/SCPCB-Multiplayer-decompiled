Function setplayervariables%()
    Local local0.breachtypes
    local0 = getbreachtype(myplayer\Field49)
    myplayer\Field24 = nickname
    myplayer\Field31 = player_isdead()
    myplayer\Field1 = entityx(collider, $00)
    myplayer\Field2 = entityy(collider, $00)
    myplayer\Field3 = entityz(collider, $00)
    myplayer\Field4 = entityyaw(camera, $00)
    myplayer\Field5 = entitypitch(camera, $00)
    myplayer\Field53 = player_move
    myplayer\Field29 = blinktimer
    If (outscp = $00) Then
        myplayer\Field4 = savedangle
    EndIf
    myplayer\Field38 = (wearinghazmat <> $00)
    myplayer\Field37 = (wearingnightvision <> $00)
    myplayer\Field36 = (wearinggasmask <> $00)
    myplayer\Field39 = (wearingvest <> $00)
    If (((-180.0 = local0\Field54) Or (local0\Field1 = haos_model)) <> 0) Then
        myplayer\Field77 = (((((((myplayer\Field38 + (myplayer\Field37 Shl $01)) + (myplayer\Field36 Shl $02)) + (myplayer\Field39 Shl $03)) + ((0.0 > gunroll) Shl $04)) + (myplayer\Field81 Shl $05)) + (myplayer\Field80 Shl $06)) + ((0.0 < gunroll) Shl $07))
    Else
        myplayer\Field77 = (((((((myplayer\Field38 + (myplayer\Field37 Shl $01)) + (myplayer\Field36 Shl $02)) + (myplayer\Field39 Shl $03)) + ((0.0 < gunroll) Shl $04)) + (myplayer\Field81 Shl $05)) + (myplayer\Field80 Shl $06)) + ((0.0 > gunroll) Shl $07))
    EndIf
    myplayer\Field34 = playersoundvolume
    myplayer\Field33 = crouchstate
    myplayer\Field35 = holdinggun
    myplayer\Field44 = playerroom\Field8\Field11
    myplayer\Field45 = playerroom\Field65
    myplayer\Field70 = ((((((myplayer\Field41 + (isgunsighting() Shl $01)) + (voice\Field4 Shl $02)) + (menuopen Shl $03)) + (myplayer\Field31 Shl $04)) + (gameload Shl $05)) + (myplayer\Field50 Shl $06))
    myplayer\Field66 = getitemid(selecteditem)
    If (networkserver\Field52\Field4 <> 0) Then
        networkserver\Field46 = $00
    EndIf
    If (networkserver\Field12 = $00) Then
        myplayer\Field68 = (100.0 - (injuries * 10.0))
    EndIf
    Return $00
End Function
