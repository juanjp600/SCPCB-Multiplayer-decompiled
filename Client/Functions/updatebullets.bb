Function updatebullets%()
    Local local0%
    Local local1%
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    If (bulletscount <= $00) Then
        Return $00
    EndIf
    local4 = (1.5 * fpsfactor)
    local5 = entityx(collider, $00)
    local6 = entityy(collider, $00)
    local7 = entityz(collider, $00)
    For local0 = $00 To (bulletscount - $01) Step $01
        If (enablebullets = $00) Then
            removebullet(local0)
            Exit
        EndIf
        local1 = (local0 * $14)
        local2 = peekint(bulletsbank, (local1 + $00))
        moveentity(local2, 0.0, 0.0, local4)
        local3 = peekfloat(bulletsbank, (local1 + $08))
        local8 = (Abs (local5 - entityx(local2, $00)))
        local9 = (Abs (local6 - entityy(local2, $00)))
        local10 = (Abs (local7 - entityz(local2, $00)))
        If (((((400.0 < local3) Or (hidedistance < local8)) Or (hidedistance < local9)) Or (hidedistance < local10)) <> 0) Then
            removebullet(local0)
            local0 = (local0 - $01)
        EndIf
    Next
    Return $00
End Function
