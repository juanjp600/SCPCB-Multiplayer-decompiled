Function fastsin#(arg0%)
    Local local0%
    Local local1#
    local0 = ((Int ((Float arg0) * 1.422222)) And $1FF)
    local1 = 1.0
    If (local0 > $FF) Then
        local0 = (local0 - $100)
        local1 = -1.0
    EndIf
    Return (((Float (($100 - local0) * local0)) * (1.0 / 16384.04)) * local1)
    Return 0.0
End Function
