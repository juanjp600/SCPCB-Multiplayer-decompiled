Function kill%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1.decals
    Local local2%
    Local local3%
    local0 = (chs\Field0 And (arg2 = $00))
    If (currentsyncplayer <> Null) Then
        If (((currentsyncplayer\Field5 = mp_getmyindex()) And local0) <> 0) Then
            Return $00
        EndIf
        mp_terminateplayer(currentsyncplayer, arg0, $00)
        If (currentsyncplayer\Field5 <> mp_getmyindex()) Then
            Return $00
        EndIf
    Else
        If (local0 <> 0) Then
            Return $00
        EndIf
        If (0.0 = me\Field0) Then
            mp_terminateplayer(ue_players[mp_getmyindex()], arg0, $00)
        EndIf
    EndIf
    If (local0 <> 0) Then
        Return $00
    EndIf
    stopbreathsound()
    If (0.0 = me\Field0) Then
        If (arg0 <> 0) Then
            local2 = loadtexture_strict("GFX\Overlays\blood_overlay.png", $01, $00, $00)
            t\Field3[$0A] = createsprite(arkblurcam)
            scalesprite(t\Field3[$0A], 1.001, (graphicheightfloat / graphicwidthfloat))
            entitytexture(t\Field3[$0A], local2, $00, $00)
            entityblend(t\Field3[$0A], $02)
            entityfx(t\Field3[$0A], $01)
            entityorder(t\Field3[$0A], $FFFFFC15)
            moveentity(t\Field3[$0A], 0.0, 0.0, 1.0)
            deletesingletextureentryfromcache(local2, $00)
            local2 = $00
            If (mp_getsocket() = $00) Then
                local3 = createpivot($00)
                positionentity(local3, (entityx(me\Field60, $00) + rnd(-0.8, 0.8)), (entityy(me\Field60, $00) - 0.05), (entityz(me\Field60, $00) + rnd(-0.8, 0.8)), $00)
                turnentity(local3, 90.0, 0.0, 0.0, $00)
                entitypick(local3, 0.3)
                local1 = createdecal($07, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, rnd(360.0, 0.0), 0.0, 0.1, 1.0, $00, $01, $00, $00, $00)
                local1\Field4 = (1.0 / 400.0)
                entityparent(local1\Field0, playerroom\Field2, $01)
                freeentity(local3)
                local3 = $00
            EndIf
        EndIf
        me\Field1 = rand($00, $01)
        me\Field7 = 0.0
        If (arg3 <> 0) Then
            playsound_strict(snd_i\Field51[$00], $00, $01)
        EndIf
        If (selecteddifficulty\Field3 >= $02) Then
            deletegame(currsave)
            gamesaved = $00
            loadsavedgames()
        EndIf
        showentity(me\Field61)
        positionentity(me\Field61, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
        resetentity(me\Field61)
        rotateentity(me\Field61, 0.0, entityyaw(camera, $00), 0.0, $00)
        me\Field0 = 1.0
        mp_meplayerdead(arg1)
    EndIf
    Return $00
End Function
