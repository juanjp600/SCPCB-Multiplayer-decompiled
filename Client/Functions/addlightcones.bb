Function addlightcones%(arg0.rooms)
    Local local0%
    For local0 = $00 To $1F Step $01
        If (arg0\Field16[local0] <> $00) Then
            arg0\Field56[local0] = copyentity(lightconemodel, $00)
            scaleentity(arg0\Field56[local0], 0.01, 0.01, 0.01, $00)
            entitycolor(arg0\Field56[local0], arg0\Field53[local0], arg0\Field54[local0], arg0\Field55[local0])
            entityalpha(arg0\Field56[local0], 0.15)
            entityblend(arg0\Field56[local0], $03)
            positionentity(arg0\Field56[local0], entityx(arg0\Field20[local0], $01), entityy(arg0\Field20[local0], $01), entityz(arg0\Field20[local0], $01), $01)
            entityparent(arg0\Field56[local0], arg0\Field20[local0], $01)
            If (arg0\Field23[local0] > $04) Then
                arg0\Field57[local0] = createsprite($00)
                scalesprite(arg0\Field57[local0], 1.0, 1.0)
                entitytexture(arg0\Field57[local0], particletextures($08), $00, $00)
                spriteviewmode(arg0\Field57[local0], $02)
                entityfx(arg0\Field57[local0], $01)
                rotateentity(arg0\Field57[local0], -90.0, 0.0, 0.0, $00)
                entityblend(arg0\Field57[local0], $03)
                entityalpha(arg0\Field57[local0], 1.0)
                positionentity(arg0\Field57[local0], entityx(arg0\Field20[local0], $01), (entityy(arg0\Field20[local0], $01) + 0.05), entityz(arg0\Field20[local0], $01), $01)
                entityparent(arg0\Field57[local0], arg0\Field20[local0], $01)
            EndIf
        EndIf
    Next
    Return $00
End Function
