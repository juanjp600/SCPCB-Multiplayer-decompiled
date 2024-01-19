Function initguns%()
    Local local0.guns
    holdinggun = $00
    shootemptysfx = loadsound_strict("SFX\Guns\shoot_empty.ogg")
    gunpivot = createpivot($00)
    muzzleflash = loadtexture("GFX\flash.jpg", $03)
    creategun($01, $01, "GFX\Guns\USP_Tactical_Viewmodel.b3d", "SFX\Guns\USP\shoot_in_01.ogg", "SFX\Guns\USP\reload1.ogg", "SFX\Guns\USP\deploy.ogg", 7.5, $0C, $0C, $0A, 1.0, 0.017, 0.017, 0.017, 0.01, 0.0, 0.02, 0.08, -0.05, 0.45)
    creategun($02, $00, "GFX\Guns\P90_Viewmodel.b3d", "SFX\Guns\P90\shoot_in_01.ogg", "SFX\Guns\P90\reload.ogg", "SFX\Guns\P90\deploy.ogg", 6.0, $32, $32, $0A, 0.8, 0.017, 0.017, 0.017, 0.01, 0.0, 0.0, 0.06, -0.05, 0.45)
    creategun($03, $00, "GFX\Guns\mp5sd_viewmodel.b3d", "SFX\Guns\MP5\shoot_in_01.ogg", "SFX\Guns\MP5\reload.ogg", "SFX\Guns\MP5\deploy.ogg", 6.0, $1E, $1E, $0A, 0.78, 0.015, 0.015, 0.015, -0.02, 0.01, -0.06, 0.06, -0.06, 0.47)
    creategun($04, $01, "GFX\Guns\rpg_viewmodel.b3d", "empty", "SFX\Guns\Bazooka\reload.mp3", "SFX\Guns\P90\deploy.ogg", 10.0, $01, $01, $05, 3.0, 0.013, 0.013, 0.013, 0.0, 0.0063, 0.0, 0.06, -0.03, 0.45)
    creategun($05, $00, "GFX\Guns\M134_Viewmodel.b3d", "SFX\Guns\Minigun\shoot.ogg", "SFX\Guns\Minigun\reload.mp3", "SFX\Guns\P90\deploy.ogg", 5.0, $64, $64, $05, 1.7, 0.013, 0.013, 0.013, 0.0, 0.01, 0.0, 0.06, -0.06, 0.45)
    creategun($06, $01, "GFX\Guns\MicroHid_Viewmodel.b3d", "SFX\Guns\MicroHID\hid.ogg", "SFX\Guns\P90\deploy.ogg", "SFX\Guns\P90\deploy.ogg", 1050.0, $01, $01, $00, 0.2, 0.013, 0.013, 0.013, 0.02, -0.05, 0.13, 0.06, -0.06, 0.45)
    creategun($07, $01, "GFX\Guns\Deagle_Viewmodel.b3d", "SFX\Guns\Deagle\shoot1.ogg", "SFX\Guns\Deagle\reload.ogg", "SFX\Guns\USP\deploy.ogg", 9.0, $07, $07, $08, 1.2, 0.02, 0.02, 0.02, 0.01, 0.0, 0.0, 0.08, -0.05, 0.45)
    creategun($08, $01, "GFX\Guns\SPAS_Viewmodel.b3d", "SFX\Guns\Shotgun\shoot1.ogg", "SFX\Guns\Shotgun\reload.mp3", "SFX\Guns\USP\deploy.ogg", 15.0, $06, $06, $05, 0.6, 0.017, 0.017, 0.017, 0.0, 0.0, 0.0, 0.08, -0.03, 0.6)
    creategun($0A, $00, "GFX\Guns\M4_Viewmodel.b3d", "SFX\Guns\M4A4\shoot1.ogg", "SFX\Guns\M4A4\reload.ogg", "SFX\Guns\USP\deploy.ogg", 7.0, $1E, $1E, $08, 0.8, 0.026, 0.026, 0.026, 0.0, 0.01, -0.03, 0.08, -0.05, 0.45)
    creategun($0B, $01, "GFX\Guns\Handcuts_Viewmodel.b3d", "", "", "SFX\Guns\USP\deploy.ogg", 1.0, $00, $00, $00, 0.0, 0.021, 0.021, 0.021, 0.05, 0.01, 0.05, 0.08, -0.05, 0.45)
    If (isahalloween() = $00) Then
        creategun($0D, $01, "GFX\Guns\grenadeviewmodel.b3d", "", "", "SFX\Guns\P90\deploy.ogg", 1.0, $00, $00, $00, 0.0, 0.02, 0.02, 0.02, 0.1, -1.2, 0.0, 0.06, -0.03, 0.6)
    Else
        creategun($0D, $01, "GFX\Guns\grenadeviewmodelHw.b3d", "", "", "SFX\Guns\P90\deploy.ogg", 1.0, $00, $00, $00, 0.0, 0.02, 0.02, 0.02, 0.1, -1.2, 0.0, 0.06, -0.03, 0.6)
    EndIf
    creategun($0E, $01, "GFX\Guns\flashgrenadeviewmodel.b3d", "", "", "SFX\Guns\P90\deploy.ogg", 1.0, $00, $00, $00, 0.0, 0.02, 0.02, 0.02, 0.1, -1.2, 0.0, 0.06, -0.03, 0.6)
    creategun($0F, $01, "GFX\Guns\smokegrenadeviewmodel.b3d", "", "", "SFX\Guns\P90\deploy.ogg", 1.0, $00, $00, $00, 0.0, 0.02, 0.02, 0.02, 0.1, -1.2, 0.0, 0.06, -0.03, 0.6)
    creategun($0C, $00, "GFX\Guns\knife_viewmodel.b3d", "", "", "SFX\Guns\P90\deploy.ogg", 35.0, $00, $00, $00, 0.0, 0.017, 0.017, 0.017, 0.01, -0.05, 0.0, 0.06, -0.05, 0.45)
    creategun($09, $00, "GFX\Guns\HKG36_Viewmodel.b3d", "SFX\Guns\HKG36\shoot.ogg", "SFX\Guns\HKG36\reload.ogg", "SFX\Guns\HKG36\deploy.ogg", 6.0, $1E, $1E, $0A, 0.8, 0.017, 0.017, 0.017, -0.02, -0.1, -0.02, 0.07, -0.05, 0.45)
    For local0 = Each guns
        Select local0\Field0
            Case $01
                addframetogun(local0, $01, $29, $00)
                addframetogun(local0, $04, $01, $25)
                addframetogun(local0, $05, $0C, $00)
                addframetogun(local0, $02, $69, $A8)
                addframetogun(local0, $03, $AB, $C5)
                setgundamage(local0, 17.0)
                addsightratetogun(local0, -0.055)
            Case $02
                addframetogun(local0, $01, $20, $00)
                addframetogun(local0, $04, $01, $1E)
                addframetogun(local0, $05, $02, $00)
                addframetogun(local0, $02, $32, $C7)
                addframetogun(local0, $03, $C8, $E4)
                addsightratetogun(local0, -0.048)
                setgundamage(local0, 18.0)
            Case $03
                addframetogun(local0, $01, $A2, $00)
                addframetogun(local0, $04, $01, $24)
                addframetogun(local0, $05, $16, $00)
                addframetogun(local0, $02, $25, $8D)
                addframetogun(local0, $03, $8E, $A1)
                addsightratetogun(local0, -0.07)
                setgundamage(local0, 18.0)
            Case $04
                addframetogun(local0, $01, $5A, $00)
                addframetogun(local0, $04, $5C, $6B)
                addframetogun(local0, $05, $5E, $00)
                addframetogun(local0, $02, $6D, $9D)
                addframetogun(local0, $03, $9F, $B3)
                addsightratetogun(local0, -0.06)
                setgundamage(local0, 90.0)
            Case $05
                addframetogun(local0, $01, $01, $00)
                addframetogun(local0, $04, $03, $21)
                addframetogun(local0, $05, $07, $00)
                addframetogun(local0, $02, $22, $B8)
                addframetogun(local0, $03, $BA, $D7)
                addsightratetogun(local0, -0.04)
                setgundamage(local0, 23.0)
            Case $06
                addframetogun(local0, $01, $5C, $00)
                addframetogun(local0, $04, $01, $51)
                addframetogun(local0, $05, $14, $00)
                addframetogun(local0, $02, $5C, $5C)
                addframetogun(local0, $03, $5E, $186)
                addsightratetogun(local0, -0.06)
                setgundamage(local0, 200.0)
            Case $07
                addframetogun(local0, $01, $20, $00)
                addframetogun(local0, $04, $01, $1F)
                addframetogun(local0, $05, $0C, $00)
                addframetogun(local0, $02, $21, $6E)
                addframetogun(local0, $03, $70, $80)
                setgundamage(local0, 24.0)
                addsightratetogun(local0, -0.04)
            Case $08
                addframetogun(local0, $01, $18, $00)
                addframetogun(local0, $04, $01, $15)
                addframetogun(local0, $05, $05, $00)
                addframetogun(local0, $02, $22, $106)
                addframetogun(local0, $03, $107, $11A)
                addshoottickstogun(local0, $06)
                setgundamage(local0, 20.0)
                addsightratetogun(local0, -0.09)
                addspreadratetogun(local0, 4.0)
            Case $0A
                addframetogun(local0, $01, $2D, $00)
                addframetogun(local0, $04, $01, $2B)
                addframetogun(local0, $05, $0C, $00)
                addframetogun(local0, $02, $38, $A0)
                addframetogun(local0, $03, $A5, $AF)
                setgundamage(local0, 22.0)
                addsightratetogun(local0, -0.072)
            Case $09
                addframetogun(local0, $01, $2D, $00)
                addframetogun(local0, $04, $01, $29)
                addframetogun(local0, $05, $14, $00)
                addframetogun(local0, $02, $4A, $96)
                addframetogun(local0, $03, $35, $49)
                setgundamage(local0, 22.0)
                addsightratetogun(local0, -0.08)
            Case $0D,$0B,$0E,$0F
                local0\Field6 = $01
            Case $0C
                addframetogun(local0, $01, $12, $00)
                addframetogun(local0, $04, $01, $10)
                addframetogun(local0, $03, $22, $37)
        End Select
    Next
    freetexture(muzzleflash)
    Return $00
End Function
