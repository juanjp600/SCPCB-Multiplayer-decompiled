Function udp_respond%()
    Return (networkserver\Field4 > (millisecs() + (networkserver\Field3 - $7D0)))
    Return $00
End Function
