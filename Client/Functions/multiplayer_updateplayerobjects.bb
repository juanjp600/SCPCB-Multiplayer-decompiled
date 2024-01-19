Function multiplayer_updateplayerobjects%(arg0.players)
    Local local0%
    If (((arg0\Field25 <> Null) And (camera <> $00)) <> 0) Then
        If ((((((arg0\Field51 <> model_966) Or multiplayer_isafriend(myplayer\Field51, arg0\Field51)) And (arg0\Field51 <> $00)) And (arg0\Field78 = $01)) And networkserver\Field25) <> 0) Then
            pointentity(arg0\Field25\Field11, camera, 0.0)
            pointentity(arg0\Field26\Field11, camera, 0.0)
            pointentity(arg0\Field27\Field11, camera, 0.0)
            If (arg0\Field28 <> Null) Then
                pointentity(arg0\Field28\Field11, camera, 0.0)
            EndIf
            local0 = (((((arg0\Field55 = $05) Or (arg0\Field55 = $09)) Or (arg0\Field55 = $0A)) Or (arg0\Field55 = $07)) Or (arg0\Field55 = $08))
            rotateentity(arg0\Field25\Field11, (- entitypitch(arg0\Field25\Field11, $00)), (entityyaw(arg0\Field25\Field11, $00) - 180.0), 0.0, $01)
            positionentity(arg0\Field25\Field11, entityx(arg0\Field13, $00), (((entityy(arg0\Field13, $00) + ((arg0\Field92 * 1.0) * 0.76)) - 0.32) - (0.32 * (Float local0))), entityz(arg0\Field13, $00), $00)
            rotateentity(arg0\Field27\Field11, entitypitch(arg0\Field25\Field11, $00), entityyaw(arg0\Field25\Field11, $00), 0.0, $01)
            positionentity(arg0\Field27\Field11, entityx(arg0\Field13, $00), (((entityy(arg0\Field13, $00) + ((arg0\Field92 * 1.0) * 0.8)) - 0.32) - (0.32 * (Float local0))), entityz(arg0\Field13, $00), $00)
            rotateentity(arg0\Field26\Field11, entitypitch(arg0\Field25\Field11, $00), entityyaw(arg0\Field25\Field11, $00), 0.0, $01)
            positionentity(arg0\Field26\Field11, entityx(arg0\Field13, $00), (((entityy(arg0\Field13, $00) + ((arg0\Field92 * 1.0) * 0.86)) - 0.32) - (0.32 * (Float local0))), entityz(arg0\Field13, $00), $00)
            If (arg0\Field28 <> Null) Then
                rotateentity(arg0\Field28\Field11, entitypitch(arg0\Field25\Field11, $00), entityyaw(arg0\Field25\Field11, $00), 0.0, $01)
                positionentity(arg0\Field28\Field11, entityx(arg0\Field13, $00), (((entityy(arg0\Field13, $00) + ((arg0\Field92 * 1.0) * 0.92)) - 0.32) - (0.32 * (Float local0))), entityz(arg0\Field13, $00), $00)
            EndIf
            If (((arg0\Field51 = myplayer\Field51) Or multiplayer_isafriend(myplayer\Field51, arg0\Field51)) <> 0) Then
                settypecolor(arg0\Field51)
            Else
                color($FF, $FF, $FF)
            EndIf
            gg_set_color(arg0\Field25, colorred(), colorgreen(), colorblue())
            showentity(arg0\Field25\Field11)
            If (networkserver\Field24 = $01) Then
                If (arg0\Field45 = $01) Then
                    showentity(arg0\Field27\Field11)
                Else
                    hideentity(arg0\Field27\Field11)
                EndIf
            Else
                hideentity(arg0\Field27\Field11)
            EndIf
            If (arg0\Field32 <> 0) Then
                showentity(arg0\Field26\Field11)
            Else
                hideentity(arg0\Field26\Field11)
            EndIf
            If (arg0\Field28 <> Null) Then
                color(arg0\Field89, arg0\Field90, arg0\Field91)
                gg_set_color(arg0\Field28, colorred(), colorgreen(), colorblue())
                showentity(arg0\Field28\Field11)
            EndIf
        Else
            hideentity(arg0\Field27\Field11)
            hideentity(arg0\Field26\Field11)
            hideentity(arg0\Field25\Field11)
            If (arg0\Field28 <> Null) Then
                hideentity(arg0\Field28\Field11)
            EndIf
        EndIf
    EndIf
    multiplayer_updateplayersize(arg0\Field0)
    Return $00
End Function
