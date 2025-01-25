Function mp_setspawnpoint%()
    Local local0.rooms
    Local local1#
    For local0 = Each rooms
        If (local0\Field7\Field6 = $03) Then
            local1 = 0.0
            Select rand($00, $0F)
                Case $00
                    tformpoint(-2874.0, 470.0, 9366.3, local0\Field2, $00)
                    local1 = -90.0
                Case $01
                    tformpoint(-2874.0, 470.0, 8839.3, local0\Field2, $00)
                    local1 = -90.0
                Case $02
                    tformpoint(-2874.0, 470.0, 8333.9, local0\Field2, $00)
                    local1 = -90.0
                Case $03
                    tformpoint(-2874.0, 470.0, 7817.3, local0\Field2, $00)
                    local1 = -90.0
                Case $04
                    tformpoint(-2874.0, 470.0, 7312.3, local0\Field2, $00)
                    local1 = -90.0
                Case $05
                    tformpoint(-2874.0, 470.0, 6043.3, local0\Field2, $00)
                    local1 = -90.0
                Case $06
                    tformpoint(-2874.0, 470.0, 5516.3, local0\Field2, $00)
                    local1 = -90.0
                Case $07
                    tformpoint(-2874.0, 470.0, 5011.1, local0\Field2, $00)
                    local1 = -90.0
                Case $08
                    tformpoint(-1534.0, 470.0, 9366.3, local0\Field2, $00)
                    local1 = 90.0
                Case $09
                    tformpoint(-1534.0, 470.0, 8839.3, local0\Field2, $00)
                    local1 = 90.0
                Case $0A
                    tformpoint(-1534.0, 470.0, 8333.9, local0\Field2, $00)
                    local1 = 90.0
                Case $0B
                    tformpoint(-1534.0, 470.0, 7817.3, local0\Field2, $00)
                    local1 = 90.0
                Case $0C
                    tformpoint(-1534.0, 470.0, 7312.3, local0\Field2, $00)
                    local1 = 90.0
                Case $0D
                    tformpoint(-1534.0, 470.0, 6043.3, local0\Field2, $00)
                    local1 = 90.0
                Case $0E
                    tformpoint(-1534.0, 470.0, 5516.3, local0\Field2, $00)
                    local1 = 90.0
                Case $0F
                    tformpoint(-1534.0, 470.0, 5011.1, local0\Field2, $00)
                    local1 = 90.0
            End Select
            positionentity(me\Field60, tformedx(), tformedy(), tformedz(), $00)
            rotateentity(me\Field60, 0.0, local1, 0.0, $00)
            resetentity(me\Field60)
            Exit
        EndIf
    Next
    Return $00
End Function
