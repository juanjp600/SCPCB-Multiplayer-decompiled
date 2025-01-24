Function removeallplayermodelmeshes%()
    Local local0.mp_modelmesh
    For local0 = Each mp_modelmesh
        removeplayermodelmesh(local0\Field0)
    Next
    Return $00
End Function
