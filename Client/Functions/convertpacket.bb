Function convertpacket%(arg0%)
    Select arg0
        Case $5B
            Return $54
        Case $5A
            Return $53
        Case $59
            Return $3D
        Case $57
            Return $42
        Case $58
            Return $32
    End Select
    Return arg0
    Return $00
End Function
