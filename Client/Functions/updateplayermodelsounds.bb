Function updateplayermodelsounds%(arg0.mp_player)
    Local local0#
    Local local1$
    Local local2.sound
    arg0\Field35\Field16 = (arg0\Field35\Field16 - fps\Field7[$00])
    If (0.0 > arg0\Field35\Field16) Then
        If (((arg0\Field35\Field14 = $00) Lor (channelplaying(arg0\Field35\Field14) = $00)) <> 0) Then
            arg0\Field35\Field14 = $00
            If (arg0\Field35\Field1\Field27 > $00) Then
                arg0\Field35\Field14 = playsound_strict(arg0\Field35\Field1\Field29[rand($00, (arg0\Field35\Field1\Field27 - $01))], $00)
            EndIf
        EndIf
        arg0\Field35\Field16 = 35.0
    EndIf
    If (arg0\Field35\Field14 <> $00) Then
        updatesoundorigin(arg0\Field35\Field14, camera, arg0\Field35\Field0, 8.0, 1.0, $00, $01)
    EndIf
    If (0.0 >= arg0\Field35\Field1\Field24[arg0\Field14]) Then
        Return $00
    EndIf
    local0 = arg0\Field35\Field1\Field24[arg0\Field14]
    arg0\Field35\Field13 = (arg0\Field35\Field13 + fps\Field7[$00])
    If (local0 < arg0\Field35\Field13) Then
        arg0\Field25 = calculateplayeradjacency(ue_players[mp_getmyindex()], arg0)
        local1 = arg0\Field35\Field1\Field12
        If (local1 = "") Then
            local2 = (Object.sound stepsfx(getstepsound(arg0\Field18), $00, rand($00, $02)))
            If (local2 <> Null) Then
                local1 = local2\Field1
            EndIf
        EndIf
        If (local1 <> "") Then
            mp_playsound(local1, 8.0, rnd(0.5, 0.8), $00, $01, $01, $00, entityx(arg0\Field18, $00), entityy(arg0\Field18, $00), entityz(arg0\Field18, $00))
        EndIf
        arg0\Field28 = max(rnd(2.0, 4.0), arg0\Field28)
        arg0\Field35\Field13 = 0.0
    EndIf
    Return $00
End Function
