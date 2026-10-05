Function initgunanims%()
    Local local0$
    Local local1.guns
    local0 = ""
    For local1 = Each guns
        Select local1\Field0
            Case $01
                local0 = "WEAPON_USP"
            Case $02
                local0 = "WEAPON_P90"
            Case $03
                local0 = "WEAPON_MP5SD"
            Case $04
                local0 = "WEAPON_BAZOOKA"
            Case $05
                local0 = "WEAPON_MINIGUN"
            Case $06
                local0 = "WEAPON_MICROHID"
            Case $07
                local0 = "WEAPON_DEAGLE"
            Case $08
                local0 = "WEAPON_SHOTGUN"
            Case $0A
                local0 = "WEAPON_M4A4"
            Case $09
                local0 = "WEAPON_HKG36"
            Case $0C
                local0 = "WEAPON_KNIFE"
            Case $0D,$0B,$0E,$0F
                local1\Field6 = $01
                local0 = ""
        End Select
        If (local0 <> "") Then
            loadgunanimfromini(local1, local0)
        EndIf
        Select local1\Field0
            Case $01
                setgundamage(local1, 5.0)
                addsightratetogun(local1, -0.055)
                addzoomtogun(local1, 10.0)
                addguncaliber(local1, "0")
            Case $02
                addsightratetogun(local1, -0.048)
                setgundamage(local1, 8.0)
                addzoomtogun(local1, 20.0)
                addguncaliber(local1, "1")
            Case $03
                addsightratetogun(local1, -0.07)
                setgundamage(local1, 10.0)
                addzoomtogun(local1, 20.0)
                addguncaliber(local1, "0")
            Case $04
                addsightratetogun(local1, -0.06)
                setgundamage(local1, 70.0)
                addzoomtogun(local1, 50.0)
                addguncaliber(local1, "4")
            Case $05
                addsightratetogun(local1, -0.01)
                addspreadratetogun(local1, 1.2)
                setgundamage(local1, 10.0)
                addzoomtogun(local1, 20.0)
                addguncaliber(local1, "1")
            Case $06
                addsightratetogun(local1, -0.06)
                setgundamage(local1, 200.0)
                addguncaliber(local1, "-1")
            Case $07
                setgundamage(local1, 30.0)
                addzoomtogun(local1, 20.0)
                addsightratetogun(local1, -0.04)
                addguncaliber(local1, "2")
            Case $08
                addshoottickstogun(local1, $05)
                setgundamage(local1, 15.0)
                addsightratetogun(local1, -0.09)
                addspreadratetogun(local1, 2.0)
                addzoomtogun(local1, 20.0)
                addguncaliber(local1, "3")
            Case $0A
                setgundamage(local1, 12.0)
                addsightratetogun(local1, -0.072)
                addzoomtogun(local1, 30.0)
                addguncaliber(local1, "1")
            Case $09
                setgundamage(local1, 13.0)
                addsightratetogun(local1, -0.08)
                addzoomtogun(local1, 30.0)
                addguncaliber(local1, "1")
        End Select
    Next
    Return $00
End Function
